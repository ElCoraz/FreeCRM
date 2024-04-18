package com.crm.free.Stack;

/*
{
    "varibles": [
        {
            "name": "a",
            "type": "Int",
            "value": 0
        },
        {
            "name": "b",
            "type": "Int",
            "value": 1
        },
        {
            "name": "c",
            "type": "Int",
            "value": 2
        }
    ],
    "opcode": [
        { 
            "line": 1,
            "cmd": "ld",
            "operand": 0 
        },
        { 
            "line": 2,
            "cmd": "ld",
            "operand": 1 
        },
        { 
            "line": 3,
            "cmd": "ld",
            "operand": 2 
        },
        { 
            "line": 4,
            "cmd": "add",
            "operand": [0, 1, 2] 
        },
        { 
            "line": 5,
            "cmd": "ret",
            "operand": 0 
        }
    ]
}
 */

public class Module {
    public Code opcodes[];
    public Varible varibles[];

    public Module(int varLength, int opcodeLength) {
        opcodes = new Code[opcodeLength];
        varibles = new Varible[varLength];
    }

}
