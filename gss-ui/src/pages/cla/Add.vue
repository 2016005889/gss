<template>
    <div>
        <el-button type="text" @click="back">返回</el-button>

        <el-form ref="form" :model="form" label-width="80px">
        
            <el-form-item label="班级">
                <el-input v-model="form.cname"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="onSubmit">提交</el-button>
                <el-button>取消</el-button>
            </el-form-item>
        </el-form>
        
    </div>
</template>

<script>
import request from '@/utils/request'
import qs from 'querystring'
export default {
    data(){
        return{
            form:{}
        } 
    },
    created(){
        this.form = this.$route.query;
    },
    methods:{
        back(){
            this.$router.go(-1);
        },
        onSubmit(){
            // 交互
            request.request({
                url:"http://127.0.0.1:9999/gss/saveOrUpdateCla",
                method:"post",
                headers:{
                    "Content-Type":"application/x-www-form-urlencoded"
                },
                data:qs.stringify(this.form)
                })
            .then(Response =>{
                // 提示成功
                 this.$message({
                    message: Response.message,
                    type: 'success'
                });
                // 返回列表页
                this.back();
            })
        }
    }
}
</script>

<style scoped>

</style>


