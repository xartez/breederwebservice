import {Dog} from "./dog";

export interface Title {
  id: string;
  name: string;
  date: Date;
  location: string;
  dog: Dog;
}
