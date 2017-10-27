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
public interface Controller {
    public void execute();
    public void init(HttpServletRequest request);
    public String getReturnPage();
}
