import java.text.SimpleDateFormat

node {
    properties([disableConcurrentBuilds(), [$class: 'GithubProjectProperty', displayName: '', projectUrlStr: 'https://github.com/nladygin/budgetapptest'], parameters([string(defaultValue: '*/master', description: '', name: 'branch', trim: true)])])

    stage('git'){
        gitResult = checkout([$class: 'GitSCM', 
                            branches: [[name: "${params.branch}"]], 
                            doGenerateSubmoduleConfigurations: false, 
                            extensions: [[$class: 'WipeWorkspace'],[$class: 'LocalBranch', localBranch: "**"]], 
                            submoduleCfg: [], 
                            userRemoteConfigs: [[url: 'https://github.com/nladygin/budgetapptest.git']]
        ])
    }
    
    stage('start-container'){
        containerName = generateName()
        containerPort = generatePort()
        appContainer = docker.image('paukiatwee/budgetapp').run("--name " + containerName + " -p " + containerPort + ":8080")
        sleep 5
    }
    
    stage('auth'){
        def workspace = pwd()
        def signup = "curl -H \"Content-Type: application/json\" -d \"{\\\"username\\\": \\\"test@test\\\", \\\"password\\\": \\\"123456\\\"}\" -X POST http://127.0.0.1:${containerPort}/api/users"
        def auth   = "curl -H \"Content-Type: application/json\" -d \"{\\\"username\\\": \\\"test@test\\\", \\\"password\\\": \\\"123456\\\"}\" -X POST http://127.0.0.1:${containerPort}/api/users/auth > ${workspace}/src/test/resources/auth.json"
            if (isUnix()){
                sh label: '', script: "${signup}"
                sh label: '', script: "${auth}"
                
            } else {
                bat label: '', script: "${signup}"
                bat label: '', script: "${auth}"
            }
    }
    
    stage('run-tests') {
        try {
            bat 'mvn clean -Dtest="api.*Test" -Dport=${containerPort} test'
        } finally {    
            testResult = junit 'target/surefire-reports/*.xml'
        }
    }
   
    parallel (
        container: {
            stage('stop-container'){
//              appContainer.stop()
                def stopContainer = "docker stop ${containerName}"
                def killContainer = "docker rm ${containerName}"
                if (isUnix()){
                    sh label: '', script: "${stopContainer}"
                    sh label: '', script: "${killContainer}"
                } else {
                    bat label: '', script: "${stopContainer}"
                    bat label: '', script: "${killContainer}"                    
                }    
            }
        },
        report: {
            stage('make-report') {
                allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'target/allure-results']]
                ])
            }
        },
        notification: {
            stage('send-notification') {
                mail to:"${gitResult.GIT_AUTHOR_EMAIL}",
                     cc: "nladygin@hrsinternational.com", 
                     subject:"test result: ${currentBuild.fullDisplayName}", 
                     body: "Build number: #${env.BUILD_NUMBER}\nBuild status: ${currentBuild.currentResult}\nBranch name: ${gitResult.GIT_BRANCH}\nResult summary: Total: ${testResult.getTotalCount()} / Passed: ${testResult.getPassCount()} / Failed: ${testResult.getFailCount()} / Skiped: ${testResult.getSkipCount()}\nJob total time: ${currentBuild.durationString}\nBuild URL: ${BUILD_URL}"
            }
        }, failFast: false
    )


}


def generatePort(){
    def dateFormat = new SimpleDateFormat("mmss")
    def date = new Date()
    return "5" + dateFormat.format(date)
}

def generateName(){
  return "budgetapp-nladygin-api-${gitResult.GIT_LOCAL_BRANCH}"
}
