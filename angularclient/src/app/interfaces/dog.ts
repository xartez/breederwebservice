import {Owner} from "./owner";
import {Title} from "./title";
import {MedicalExam} from "./medicalExam";
import {Litter} from "./litter";
import {Training} from "./training";
import {Reservation} from "./reservation";

export interface Dog {
  id: string;
  name: string;
  profileImageUrl: string;
  breed: string;
  origin: string;
  age: number;
  birthDate: Date;
  sex: string;
  titles: Title[];
  medicalExams: MedicalExam[];
  owner: Owner;
  originLitter: Litter;
  ownLitters: Litter[];
  kennel: string;
  trainings: Training[];
  reservation: Reservation;

}

