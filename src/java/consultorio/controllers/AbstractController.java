/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.controllers;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Jessica Silveira/ Jpyce Miyazato/ Felipe Figoli
 */
public abstract class AbstractController implements Controller {
    public HttpServletRequest request;
    protected String returnPage;
    public void init(HttpServletRequest request) {
        this.setRequest(request);
    }
    public void setReturnPage(String page) {
        returnPage = page;
    }
    public String getReturnPage() {
        return returnPage;
    }
    public HttpServletRequest getRequest() {
        return request;
    }
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
    
}
