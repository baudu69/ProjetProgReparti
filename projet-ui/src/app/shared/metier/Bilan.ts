import {IApprenant} from "./Apprenant";
import {IMission} from "./Mission";
import {IAction} from "./Action";
import {IObtenir} from "./Obtenir";

export interface IBilan {
  apprenant: IApprenant;
  missionBilans: IMissionBilan[];
}

export interface IMissionBilan {
  mission: IMission;
  actionBilans: IActionBilan[];
}

export interface IActionBilan {
  action: IAction;
  obtenir: IObtenir;
}

