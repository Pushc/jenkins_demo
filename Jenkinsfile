pipeline {
    agent any

    environment {
        KUBECONFIG = '/home/pushkar8983/.kube/config'
    }

    stages {
        stage('Verify') {
            steps {
                sh '''
                whoami
                docker ps
                kubectl get nodes
                '''
            }
        }
    }
}