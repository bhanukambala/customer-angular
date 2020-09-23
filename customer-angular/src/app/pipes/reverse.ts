import { Pipe, PipeTransform } from "@angular/core";


@Pipe(
    {
        name:'reverse'
    }
)
export class ReversePipe implements PipeTransform{
    transform(value: string){
        let reverse:string="";
        for(let i=value.length-1;i>=0;i--){
            reverse = reverse+value.charAt(i);
        }
        console.log("inside reverse string, reversed string="+reverse);
        return reverse;
    }
     
}