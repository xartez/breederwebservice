import {Dog} from "./dog";

export interface MedicalExam {
  id: string;
  medicalExamination: string;
  scanUrl: string;
  dog: Dog;
}
