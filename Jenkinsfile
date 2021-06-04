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
    }
}