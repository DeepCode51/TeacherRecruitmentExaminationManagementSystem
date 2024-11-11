const base = {
    get() {
        return {
            url : "http://localhost:8080/ssmm7i10/",
            name: "ssmm7i10",
            // 返回到首页
            indexUrl: 'http://localhost:8080/ssmm7i10/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "教师招聘考试系统"
        } 
    }
}
export default base
