<template>
    <div>
        <el-button type="primary" size="small" @click="toAddAcademy">添加学院</el-button>
      
        <el-table :data="tableData" style="width: 100%">
            <el-table-column prop="aid" label="编号" width="80"></el-table-column>
            <el-table-column prop="aname" label="学院" width="150"></el-table-column>

            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button size="mini"  @click="toEditAcademy(scope.row)">编辑</el-button>
                    <el-button size="mini" type="danger" @click="deleteAcademy(scope.row.aid)">删除</el-button>
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
       this.reloadDate()
    },
    // 模板中要用到的方法
    methods:{
        reloadDate(){
            // 查询所有用户信息
            request.get("http://127.0.0.1:9999/gss/findAllAcademys")
            .then(Response =>{
                this.tableData = Response.data;
            })
        },
        toAddAcademy(){
            // 跳转页面
            this.$router.push({path:'/academy/add'})
        },
        toEditAcademy(row){
            this.$router.push({
                path:'/academy/add',
                query:row
            })
        },
        deleteAcademy(aid){
            this.$confirm('此操作将永久删除该学院, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
            }).then(() => {
                let url = "http://127.0.0.1:9999/gss/deleteAcademyByAid"
                request.get(url,{params:{aid}})
                .then(Response =>{
                     this.$message({
                        type: 'success',
                        message: '删除成功!'
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


