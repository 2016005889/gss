package com.tyut.apps.gss.bean.extend;

import com.tyut.apps.gss.bean.Academy;
import com.tyut.apps.gss.bean.Base;
import com.tyut.apps.gss.bean.Cla;
import com.tyut.apps.gss.bean.Role;

public class BaseExtend  extends Base {


    private Role roles;

    private Cla cla;

    private Academy academy;

//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }


    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    public Cla getCla() {
        return cla;
    }

    public void setCla(Cla cla) {
        this.cla = cla;
    }

    public Academy getAcademy() {
        return academy;
    }

    public void setAcademy(Academy academy) {
        this.academy = academy;
    }
}
