void setBuildStatus(String message, String state) {
        step([
            $class: "GitHubCommitStatusSetter",
            reposSource: [$class: "ManuallyEnteredRepositorySource", url: "https://github.com/team2059/2018-bot"],
            contextSource: [$class: "ManuallyEnteredCommitContextSource", context: "ci/jenkins/build-status"],
            errorHandlers: [[$class: "ChangingBuildStatusErrorHandler", result: "UNSTABLE"]],
            statusResultSource: [ $class: "ConditionalStatusResultSource", results: [[$class: "AnyBuildResult", message: message, state: state]] ]
        ]);
}

def notifySlack(String buildStatus = 'STARTED') {
    // Build status of null means success.
    buildStatus = buildStatus ?: 'SUCCESS'

    def color

    if (buildStatus == 'STARTED') {
        color = '#D4DADF'
    } else if (buildStatus == 'SUCCESS') {
        color = '#BDFFC3'
    } else if (buildStatus == 'UNSTABLE') {
        color = '#FFFE89'
    } else {
        color = '#FF9FA1'
    }

    def msg = "${buildStatus}: `${env.JOB_NAME}` #${env.BUILD_NUMBER}:\n${env.BUILD_URL}"

    slackSend baseUrl: 'https://team2059.slack.com/services/hooks/jenkins-ci/', botUser: true, channel: '#builds', color: color, message: msg, teamDomain: 'team2059', tokenCredentialId: 'team2059slack'
}

pipeline {
    agent any
    stages {
        stage('Git') {
            steps {
                notifySlack()
                deleteDir()
                git branch: '**', credentialsId: 'a14847e5-f1a5-48d1-8833-9709f75f8471', url: 'git@github.com:team2059/2018-bot.git'
                sshagent(['a14847e5-f1a5-48d1-8833-9709f75f8471']) {
                    sh 'git submodule update --init --recursive'
                }
            }
        }
    
        stage('Build') {
            steps {
                sh 'ant compile'
            }
        }
    }
    post {
        success {
            setBuildStatus('Build succeeded', 'SUCCESS');
            notifySlack('SUCCESS')
        }
        failure {
            setBuildStatus('Build failed', 'FAILURE');
            notifySlack('FAILURE')
        }
        unstable {
            setBuildStatus('Build unstable', 'PENDING');
            notifySlack('UNSTABLE')
        }
        aborted {
            setBuildStatus('Build aborted', 'FAILURE');
            notifySlack('ABORTED')
        }
    }
}