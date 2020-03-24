<template>
    <div>
        <el-button type="text" @click="back">返回</el-button>
       {{form}}
        <el-form ref="form" :model="form" label-width="80px">
            <el-form-item label="姓名">
                <el-input v-model="form.name"></el-input>
            </el-form-item>
            <el-form-item label="学号/工号">
                <el-input v-model="form.sno"></el-input>
            </el-form-item>

            <el-form-item label="性别">
                <el-select v-model="form.gender" placeholder="请选择性别">
                <el-option label="男" value="男"></el-option>
                <el-option label="女" value="女"></el-option>
                </el-select>
            </el-form-item>

            <el-form-item label="邮箱">
                <el-input v-model="form.email"></el-input>
            </el-form-item>

            <el-form-item label="电话">
                <el-input v-model="form.phone"></el-input>
            </el-form-item>

            <el-form-item label="QQ">
                <el-input v-model="form.qq"></el-input>
            </el-form-item>

            <el-form-item label="角色">
                <el-input v-model="form.rname"></el-input>
            </el-form-item>

            <el-form-item label="班级">
                <el-input v-model="form.cname"></el-input>
            </el-form-item>

            <el-form-item label="学院">
                <el-input v-model="form.aname"></el-input>
            </el-form-item>
            
            <!-- <el-form-item label="角色">
                <el-select v-model="form.rname" placeholder="请选择角色">
                <el-option label="学生" value="学生"></el-option>
                <el-option label="教师" value="教师"></el-option>
                <el-option label="管理员" value="管理员"></el-option>
                </el-select>
            </el-form-item>

            <el-form-item label="班级">
                <el-select v-model="form.cname" placeholder="请选择班级">
                <el-option label="软件1601班" value="软件1601班"></el-option>
                <el-option label="软件1602班" value="软件1602班"></el-option>
                <el-option label="软件1603班" value="软件1603班"></el-option>
                </el-select>
            </el-form-item>

            <el-form-item label="学院">
                <el-select v-model="form.aname" placeholder="请选择学院">
                <el-option label="软件学院" value="软件学院"></el-option>
                <el-option label="计算机科学与技术学院" value="计算机科学与技术学院"></el-option>
                </el-select>
            </el-form-item> -->
           
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
                url:"http://127.0.0.1:9999/gss/saveOrUpdateBase",
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


