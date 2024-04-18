package com.crm.free.Stack;

public enum OpCode {
    ld(0),
    add(1),
    ret(2);

    @SuppressWarnings("unused")
    private int value;  

    private OpCode(int value) {  
        this.value = value;  
    }  

    private OpCode(String value) { 
        switch (value) {
            case "ld": {
                this.value = 0;                
                break;
            }
            case "add": {
                this.value = 1;                
                break;
            }
            case "ret": {
                this.value = 3;                
                break;
            }
                default: {
                break;
            }
        }
    }  
}
