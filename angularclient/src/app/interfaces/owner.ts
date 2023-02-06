import { Dog } from "./dog";

export interface Owner {
  id: string;
  name: string;
  lastName: string;
  phoneNumber: string;
  location: string;
  kennel: string;
  dogs: Dog[];
}
