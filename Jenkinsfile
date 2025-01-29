pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh 'date'
            }
        }
        stage('docker images ls') {
            steps {
                sh 'docker images'
            }
        }
    }
}
