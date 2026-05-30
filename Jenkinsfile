pipeline {
    agent any

    stages {

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t demo-app .'
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                docker stop demo-container || true
                docker rm demo-container || true

                docker run -d \
                --name demo-container \
                -p 8081:8080 \
                demo-app
                '''
            }
        }
    }
}