export class CosmeticMaster {
    
    public type: string;
    public code: string;
    public value: string;

    getType(){
        return this.type;
    }
    setType(type: string){
        this.type = type;
    }

    getCode(){
        return this.code;
    }
    setCode(code: string){
        this.code = code;
    }

    getValue(){
        return this.value;
    }
    setValue(value: string){
        this.value = value;
    }
}