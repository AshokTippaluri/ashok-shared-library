pipeline {
    agent any

    environment {
        IMAGE_NAME = "ng_project"
        CONTAINER_NAME = "NG_nginx-container"
        HTML_REPO = "https://github.com/AshokTippaluri/web.git"
        WORK_DIR = "/tmp/workdir"
        HTML_SUBDIR = "order-summary-component-card"  // Set subdirectory name
        PORT = "8085"  // Change this if needed
    }

    stages {
        stage('Clean Workspace') {
            steps {
                sh "rm -rf ${WORK_DIR} || true"
            }
        }

        stage('Clone Repository') {
            steps {
                sh """
                    git clone ${HTML_REPO} ${WORK_DIR}
                    if [ ! -d "${WORK_DIR}/${HTML_SUBDIR}" ]; then
                        echo "❌ ERROR: Directory ${HTML_SUBDIR} NOT found in repo!"
                        ls -R ${WORK_DIR}  # Debugging output
                        exit 1  # Fail pipeline if directory is missing
                    fi
                """
            }
        }

        stage('Remove Existing Container') {
            steps {
                script {
                    sh """
                        docker stop ${CONTAINER_NAME} || true
                        docker rm ${CONTAINER_NAME} || true
                    """
                }
            }
        }

        stage('Run Nginx Container') {
            steps {
                script {
                    sh """
                        docker run -d --name ${CONTAINER_NAME} -p ${PORT}:80 \\
                        -v ${WORK_DIR}/${HTML_SUBDIR}:/usr/share/nginx/html \\
                        nginx:latest
                    """
                }
            }
        }
    }

    post {
        success {
            echo "✅ Deployment Successful! Access the site at http://localhost:${PORT}/"
        }
        failure {
            echo "❌ Deployment Failed. Check Jenkins logs for details."
        }
    }
}
