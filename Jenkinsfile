pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh 'date'
            }
        }
        stage('List Docker Images') {
            steps {
                sh 'docker images'
            }
        }
        stage('Nginx installation Docker') {
            steps {
                sh 'docker run -d -p 8085:80 --name test-container nginx:alpine'
            }
        }
    }
}
