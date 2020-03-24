<template>
    <div>
        
        <el-button type="primary" size="small" @click="toAddBase">添加用户</el-button>
        <!-- <el-button type="danger" size="small" @click="batchDeleteBase">批量删除</el-button>
        {{bids}} -->
        <el-table :data="tableData" style="width: 100%" @selection-change="handleSelectionChange">

            <el-table-column type="selection" width="55"></el-table-column>

            <el-table-column prop="bid" label="编号" width="80"></el-table-column>
            <el-table-column prop="name" label="姓名" width="80"></el-table-column>
            <el-table-column prop="sno" label="学号/工号" width="100"></el-table-column>
            <el-table-column prop="gender" label="性别" width="80"></el-table-column>
            <el-table-column prop="phone" label="手机号" width="120"></el-table-column>
            <el-table-column prop="qq" label="QQ" width="100"></el-table-column>
            <el-table-column prop="email" label="邮箱" width="180"></el-table-column>
            <el-table-column prop="cla.cname" label="班级" width="130"></el-table-column>
            <el-table-column prop="academy.aname" label="学院" width="80"></el-table-column>
            <el-table-column prop="roles.rname" label="角色" width="80"></el-table-column>

            <el-table-column label="操作">
                <template slot-scope="scope">
                    
                    <el-button size="mini"  @click="toEditBase(scope.row)">编辑</el-button>
                    <el-button size="mini" type="danger" @click="deleteBase(scope.row.bid)">删除</el-button>
                </template>
            </el-table-column>
    </el-table>
    </div>
</template>

<script>
import request from '@/utils/request'
import qs from 'querystring'
export default {
    // 模板中要用到的变量
    data(){
        return{
            tableData:[],
        }
    },
    // 声明周期钩子函数
    created(){
        this.reloadDate();
    },
    // 模板中要用到的方法
    methods:{
        // 初始加载数据信息
        reloadDate(){
            // 查询所有用户信息
            request.get("http://127.0.0.1:9999/gss/findAllBases")
            .then(Response =>{
                this.tableData = Response.data;
            })
        },
        // 添加成员的界面
        toAddBase(){
            // 跳转页面
            this.$router.push({path:'/base/add'})
        },
        // 编辑信息
        toEditBase(row){
            this.$router.push({
                path:'/base/add',
                query:row
            })
        },
        // 删除
        deleteBase(bid){
            this.$confirm('此操作将永久删除该用户, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
            }).then(() => {
                let url = "http://127.0.0.1:9999/gss/deleteBaseByBid"
                request.get(url,{params:{bid}})
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


