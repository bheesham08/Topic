pipeline {
    agent any

    stages {
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
                        sh 'mvn clean compile'
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
                   sshagent(['deploy_user1']) {
                       sh "scp -o StrictHostKeyChecking=no webapp/target/webapp.war ec2-user@ec2-54-90-156-62.compute-1.amazonaws.com:8090/:apache-tomcat-9.0.39/webapp"

                        }
                   }
             }

        }
    }

