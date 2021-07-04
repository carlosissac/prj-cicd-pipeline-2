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
    post {  
        //always {  
           // echo 'This will always run'  
        //}  
        //success {  
            //echo 'This will run only if successful'  
        //}  
        failure {  
            //echo 'This will run only if build fails'
            mail to: 'stux.xyz.work@gmail.com',
            subject: "FAILED: Build ${env.JOB_NAME}", 
            body: "Build failed ${env.JOB_NAME} build no: ${env.BUILD_NUMBER}.\n\nView the log at:\n ${env.BUILD_URL}\n\nBlue Ocean:\n${env.RUN_DISPLAY_URL}"
        }  
        //unstable {
           // echo 'This will run only if build is unstable'  
        //}  
        //changed {
           // echo 'This will run only if build changes'
        //}  
    }  
}