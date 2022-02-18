import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})

export class UtilService {

    public maskPhoneNumber(phoneNumber: number, countryId: number): string {

        return this.formatPhone(phoneNumber.toString(), countryId)
            .replace(/\D/g, "")
            .replace(/(\d{3})(\d)/, "($1) $2")
            .replace(/(\d{20})(\d)/, "$1$2");

    }

    public isValid(phoneNumber: string, countryId: number): boolean {

        switch (countryId) {
            case 212:
                return /^\(212\)\ ?[5-9]\d{8}$/.test(this.formatPhone(phoneNumber, countryId))

            case 237:
                return /^\(237\)\ ?[2368]\d{7,8}$/.test(this.formatPhone(phoneNumber, countryId))

            case 251:
                return /^\(251\)\ ?[1-59]\d{8}$/.test(this.formatPhone(phoneNumber, countryId))

            case 256:
                return /^\(256\)\ ?\d{9}$/.test(this.formatPhone(phoneNumber, countryId))

            case 258:
                return /^\(258\)\ ?[28]\d{7,8}$/.test(this.formatPhone(phoneNumber, countryId))
            
            default:
                return false;
        }

    }

    private formatPhone(phoneNumber: string, countryId: number): string {
        return '(' + countryId.toString() + ')'.concat(phoneNumber.toString());
    }

}