pipeline {
    agent any

    environment {
        KUBECONFIG = '/home/pushkar8983/.kube/config'
        IMAGE_NAME = "springboot-k8s:${BUILD_NUMBER}"
    }

    stages {

        stage('Build JAR') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh '''
                docker build -t $IMAGE_NAME .
                '''
            }
        }

        stage('Load Image To Minikube') {
            steps {
                sh '''
                minikube image load $IMAGE_NAME
                '''
            }
        }

        stage('Deploy To Kubernetes') {
            steps {
                sh '''
                kubectl set image deployment/springboot-app \
                springboot-app=$IMAGE_NAME
                '''
            }
        }

        stage('Verify') {
            steps {
                sh '''
                kubectl rollout status deployment/springboot-app
                kubectl get pods
                '''
            }
        }
    }
}