pipeline {
    agent any

    stages {
        stage('SCM') {
            steps {
              git 'https://github.com/bheesham08/Topic'
            }
         }
        stage ('Clean Stage') {

                steps {
                    withMaven(maven : 'MAVEN_HOME') {
                        sh 'mvn clean'
                    }
                }
            }
            stage ('Validate Stage') {
                steps {
                     withMaven(maven : 'MAVEN_HOME') {
                        sh 'mvn clean'
                        }
                     }
                }
            stage ('Compile Stage') {

                steps {
                    withMaven(maven : 'MAVEN_HOME') {
                        sh 'mvn clean install'
                    }
                }
            }
             stage ('Package Stage') {

                    steps {
                        withMaven(maven : 'MAVEN_HOME') {
                            sh 'mvn package'
                        }
                    }
             }

             stage ('Testing Stage') {

                    steps {
                        withMaven(maven : 'MAVEN_HOME') {
                            sh 'mvn test'
                        }
                    }
             }
          
             stage ('Deploy Stage') {

                   steps {
                   sshagent(['deploy_user']) {
                       sh "scp -o StrictHostKeyChecking=no target/SpringBootQuickStart-0.0.1-SNAPSHOT.jar ec2-user@ec2-35-175-194-80.compute-1.amazonaws.com:/home/ec2-user/apache-tomcat-9.0.39/webapps"

                        }
                 }
            }

        
        }
}
