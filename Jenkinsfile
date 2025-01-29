pipeline {
    agent any

    environment {
        IMAGE_NAME = "ng_project"
        CONTAINER_NAME = "NG_nginx-container"
        HTML_REPO = "https://github.com/AshokTippaluri/web.git"
        WORK_DIR = "/tmp/workdir"
    }

    stages {
        stage('Clone Repository') {
            steps {
                sh "rm -rf ${WORK_DIR} && git clone ${HTML_REPO} ${WORK_DIR}"

                sh """
                  if [ -d "${WORK_DIR}/web/order-summary-component-card" ]; then
                        echo "Directory exists"
                        cd ${WORK_DIR}/web/order-summary-component-card
                  else
                       echo "Directory NOT found!"
                       ls -R ${WORK_DIR}  # Debugging output
                       exit 1  # Stop the build if the directory is missing
                  fi
                 """

                sh "cd /tmp/workdir/web/order-summary-component-card"
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh """
                        cd ${WORK_DIR}
                        echo 'FROM nginx:latest' > Dockerfile
                        echo 'COPY . /usr/share/nginx/html' >> Dockerfile
                        docker build -t ${IMAGE_NAME} .
                    """
                }
            }
        }

        stage('Run Nginx Container') {
            steps {
                script {
                    sh """
                        docker stop ${CONTAINER_NAME} || true
                        docker rm ${CONTAINER_NAME} || true
                        docker run -d --name ${CONTAINER_NAME} -p 8085:80 ${IMAGE_NAME}
                    """
                }
            }
        }
    }
}
