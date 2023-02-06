import {Dog} from "./dog";

export interface Litter {
  id: string;
  letter: string;
  name: string;
  breed: string;
  mother: string;
  father: string;
  size: number;
  bitchNum: number;
  dogNum: number;
  birthDate: Date;
  dogs: Dog[];
}
