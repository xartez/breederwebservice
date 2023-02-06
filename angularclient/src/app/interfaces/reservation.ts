import {Dog} from "./dog";

export interface Reservation {
  id: string;
  price: string;
  paid: string;
  dog: Dog;
}
