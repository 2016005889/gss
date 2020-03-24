<template>
    <div>
        <el-button type="primary" size="small" @click="toAddCla">添加班级</el-button>
      
        <el-table :data="tableData" style="width: 100%">
            <el-table-column prop="cid" label="编号" width="80"></el-table-column>
            <el-table-column prop="cname" label="班级" width="150"></el-table-column>

            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button size="mini"  @click="toEditCla(scope.row)">编辑</el-button>
                    <el-button size="mini" type="danger" @click="deleteCla(scope.row.cid)">删除</el-button>
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
            request.get("http://127.0.0.1:9999/gss/findAllClas")
            .then(Response =>{
                this.tableData = Response.data;
            })
        },
        toAddCla(){
            // 跳转页面
            this.$router.push({path:'/cla/add'})
        },
        toEditCla(row){
            this.$router.push({
                path:'/cla/add',
                query:row
            })
        },
        deleteCla(cid){
            this.$confirm('此操作将永久删除该班级, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
            }).then(() => {
                let url = "http://127.0.0.1:9999/gss/deleteClaByCid"
                request.get(url,{params:{cid}})
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


