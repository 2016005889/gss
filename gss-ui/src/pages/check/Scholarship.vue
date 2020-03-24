<template>
    <div>

        <el-table :data="tableData" style="width: 100%">
            <el-table-column prop="bid" label="编号" width="50"></el-table-column>
            <el-table-column prop="name" label="姓名" width="80"></el-table-column>
            <el-table-column prop="sno" label="学号" width="100"></el-table-column>
            <el-table-column prop="gender" label="性别" width="50"></el-table-column>
            <el-table-column prop="phone" label="手机号" width="120"></el-table-column>
            <el-table-column prop="qq" label="QQ" width="100"></el-table-column>
            <el-table-column prop="email" label="邮箱" width="180"></el-table-column>
            <el-table-column prop="cla.cname" label="班级" width="130"></el-table-column>
            <el-table-column prop="academy.aname" label="学院" width="80"></el-table-column>
            <el-table-column prop="detailed.address" label="地址" width="150"></el-table-column>
            <el-table-column prop="detailed.bankcard" label="银行卡" width="180"></el-table-column>
            <el-table-column prop="detailed.idcard" label="身份证号" width="180"></el-table-column>
            <el-table-column prop="scholarship.grade" label="成绩" width="80"></el-table-column>

            <el-table-column label="操作">
                <template slot-scope="scope">
                    
                     <div v-if="scope.row.scholarship.status < 1">
                        <el-button size="mini" type="primary"  @click="toUpdateStatus(scope.row.scholarship.scid)">通过</el-button>
                     </div>
                     <div v-else-if="scope.row.scholarship.status > 0">
                         <el-button size="mini" type="success" disabled="true">已审核</el-button>
                     </div>
                </template>
            </el-table-column>
            
    </el-table>
    </div>
</template>

<script>
import request from '@/utils/request'
export default {
    // 模板中要用到的变量
    data(){
        return{
            tableData:[]
        }
    },
    // 声明周期钩子函数
    created(){
       this.reloadDate();
    },
    // 模板中要用到的方法
    methods:{
        reloadDate(){
             // 查询所有用户信息
            request.get("http://127.0.0.1:9999/gss/findAllScholarship")
            .then(Response =>{
                this.tableData = Response.data;
            })
        },
         
        // 审核
        toUpdateStatus(scid){
            this.$confirm('此操作将通过审核, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
            }).then(() => {
                let url = "http://127.0.0.1:9999/gss/updateScholarshipStatus"
                request.get(url,{params:{scid}})
                .then(Response =>{
                     this.$message({
                        type: 'success',
                        message: '审核成功!'
                     });  
                     // 重载数据
                     this.reloadDate();
                })
            })
        }
        
    }
};
</script>

<style scoped>
</style>


