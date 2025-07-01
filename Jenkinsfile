pipeline {
    agent any
    environment {
        ACR = 'springbootk8.azurecr.io'
        IMAGE = "${ACR}/springboot-k8:${BUILD_NUMBER}"
    }
    stages {
        stage('Build') {
            steps {
                sh './mvnw clean package -DskipTests'
            }
        }
        stage('Docker Build & Push') {
            steps {
                sh 'podman build -t $IMAGE .'
                sh 'podman push $IMAGE'
            }
        }
        stage('Update CD Repo') {
            steps {
                sh '''
                git clone https://github.com/manojnanjundaswamy/springboot-k8-deploy.git
                cd springboot-k8-deploy
                sed -i "s/tag:.*/tag: ${BUILD_NUMBER}/" charts/springboot-k8/values-prod.yaml
                git config user.name "manojnanjundaswamy"
                git config user.email "manojnanjundaswamy@gmail.com"
                git commit -am "Update image tag to ${BUILD_NUMBER}"
                git push origin main
                '''
            }
        }
    }
}
