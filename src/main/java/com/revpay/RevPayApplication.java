package com.revpay;

import com.revpay.controller.AuthController;

public class RevPayApplication 
{
    public static void main( String[] args )
    {
        AuthController authController = new AuthController();
        authController.start();
    }
}
