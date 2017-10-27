/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.controllers;

/**
 *
 * @author Jessica Silveira/ Jpyce Miyazato/ Felipe Figoli
 */
public class ControllerFactory {
            public static final Controller getControllerByClass(Class actionClass) {
        try {
            Controller controller = (Controller) actionClass.newInstance();
            return (Controller) actionClass.newInstance();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static final Controller getControllerByFullClassName(String className) {
        try {
            String name = "consultorio.controllers.impl." + className + "Controller";
            Class actionClass = Class.forName(name);
            return getControllerByClass(actionClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}