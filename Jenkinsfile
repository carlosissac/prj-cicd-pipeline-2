pipeline {
    agent none
    tools {
        maven 'ubu_maven'
    }
    stages {
        stage('checkout') {
            agent { 
                label 'TOMCAT01'
            }
            steps {
                git branch: 'main',
                url: 'https://github.com/carlosissac/prj-cicd-pipeline-2.git'
            }
        }
        stage('build') {
            agent {
                label 'TOMCAT01'
            }
            steps {
                sh 'mvn clean package -DskipTests=true'
            }
        }
        stage('test') {
            agent {
                label 'TOMCAT01'
            }
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
        stage('deploy') {
            agent {
                label 'TOMCAT01'
            }
            steps {
                sh 'cp -r /tmp/workspace/Job07-NightlyBuildEmailAlerts-FinalJob/target/bookzy-0.0.1-SNAPSHOT.war /tmp/apache-tomcat-8.5.68/webapps'
            }
        }
    }
}