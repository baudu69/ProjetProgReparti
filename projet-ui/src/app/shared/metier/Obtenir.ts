export interface IObtenir {
  id: IObtenirId;
  dateObtention: Date;
  valeurDebut: number;
  valeurFin: number;
  retourMoniteur: string;
}

export interface IObtenirId {
  idApprenant: number;
  idAction: number;
}
