export interface Serie {
  id:            number;
  title:         string;
  image:         string;
  numberSeasons: number;
  releaseDate:   Date;
  synopsis:      string;
  categories:    string[];
  seasons:       Season[];
}

export interface Season {
  id:          number;
  name:        string;
  chapters:    number;
  releaseDate: Date;
  trailer:     string;
}
