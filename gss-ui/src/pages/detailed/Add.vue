<template>
    <div>
        {{sno}}      
        <el-form ref="form" :data="detailData" :model="form" label-width="80px">
        
            <el-form-item label="学号">
                <el-input v-model="form.cname"></el-input>
            </el-form-item>

            <el-form-item label="地址">
                <el-input v-model="form.cname"></el-input>
            </el-form-item>

            <el-form-item label="银行卡号">
                <el-input v-model="form.cname"></el-input>
            </el-form-item>

            <el-form-item label="身份证号">
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
            form:{},
            sno,
            detailData:{}
        } 
    },
    created(){
        this.form = this.$route.query;
        this.sno = sessionStorage.getItem('sno');
        this.findDetail();
    }, 
    methods:{
        findDetail(){
            let url = "http://127.0.0.1:9999/gss/findDetailedBySno"
            request.get(url,{params:{sno}})
            .then(Response =>{
                this.detailData = Response.data
            })
        }
        ,
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
            })
        }
    }
}
</script>

<style scoped>

</style>


