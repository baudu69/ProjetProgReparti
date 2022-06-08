import {IIndicator} from "./Indicator";

export interface IAction {
  id: number;
  wording: string;
  scoreMinimum: number;
  indicator: IIndicator[];
}
