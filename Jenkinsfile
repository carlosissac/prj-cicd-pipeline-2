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
        stage('compile') {
            agent {
                label 'TOMCAT01'
            }
            steps {
                sh 'mvn clean package'
            }
        }
        stage('test') {
            agent {
                label 'TOMCAT01'
            }
            steps {
                sh 'mvn test'
            }
        }
        stage('deploy') {
            agent {
                label 'TOMCAT01'
            }
            steps {
                sh 'cp -r /tmp/workspace/Job05-PipelineJenkinsfile/target/bookzy-0.0.1-SNAPSHOT.war /tmp/apache-tomcat-8.5.68/webapps'
            }
        }
    }
}