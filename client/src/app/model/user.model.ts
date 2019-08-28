export class User {

    public id: string;
    public fullName: string;
    public mobileNumber: string;

    getId(): string {
        return this.id
    }

    setId(id: string) {
        this.id = id;
    }

    getFullName(): string{
        return this.fullName;
    }

    setFullName(fullName: string){
        this.fullName = fullName;
    }

    getMobileNumber(): string {
        return this.mobileNumber;
    } 

    setMobileNumber(mobileNumber: string){
        this.mobileNumber = mobileNumber;
    }
 }