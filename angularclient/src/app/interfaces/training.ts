import {Dog} from "./dog";

export interface Training {
  id: string;
  name: string;
  date: Date;
  location: string;
  dogs: Dog[];
}
