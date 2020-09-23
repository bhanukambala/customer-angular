import { Pipe, PipeTransform } from '@angular/core';

@Pipe(
    { 
        name:'length'
    }
)

export class LengthPipe implements PipeTransform{
    transform(input: string):number {
    console.log("inside length pipe ");
    return input.length;
    }
    
}
    
       
    