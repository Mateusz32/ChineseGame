package com.chinesegame;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Moves {

    Random whoStart = new Random();

    public int moveFromBase(int resultOfDice, List<Pawn> homePawns, List<Pawn> basePawns,
                            ImageView imageView1, ImageView imageView2, ImageView imageView3, ImageView imageView4,
                            Map<Integer, Point> theTrackOfPawns, GridPane grid, int start) {
        if ((homePawns.size() == 4 && basePawns.size() == 0)) {
            if (resultOfDice == 6) {
                grid.getChildren().remove(imageView4);
                homePawns.remove(homePawns.size() - 1);
                grid.add(imageView4, theTrackOfPawns.get(1).getColumn(), theTrackOfPawns.get(1).getRow());
                start = 1;
            }
        } else if ((homePawns.size() == 3 && basePawns.size() == 1)) {
            if (resultOfDice == 6) {
                homePawns.remove(homePawns.size() - 1);
                grid.getChildren().remove(imageView3);
                grid.add(imageView3, theTrackOfPawns.get(1).getColumn(), theTrackOfPawns.get(1).getRow());
                start = 1;
            }
        } else if ((homePawns.size() == 2 && basePawns.size() == 2)) {
            if (resultOfDice == 6) {
                homePawns.remove(homePawns.size() - 1);
                grid.getChildren().remove(imageView2);
                grid.add(imageView2, theTrackOfPawns.get(1).getColumn(), theTrackOfPawns.get(1).getRow());
                start = 1;
            }
        } else if ((homePawns.size() == 1 && basePawns.size() == 3)) {
            if (resultOfDice == 6) {
                homePawns.remove(homePawns.get(0));
                grid.getChildren().remove(imageView1);
                grid.add(imageView1, theTrackOfPawns.get(1).getColumn(), theTrackOfPawns.get(1).getRow());
                start = 1;
            }
        }
        return start;
    }

    public int pawnsMove(int resultOfDice, List homePawns, List basePawns,
                         ImageView imageView1, ImageView imageView2, ImageView imageView3, ImageView imageView4,
                         Map<Integer, Point> theTrackOfPawns, GridPane grid, int start) {
        if (basePawns.size() == 3 && homePawns.size() == 0) {
            int startPosition = start;
            int endPosition = resultOfDice + startPosition;
            if (endPosition > 44) {
                endPosition = startPosition;
            }
            if (endPosition == 44) {
                homePawns.add(imageView4);
                grid.getChildren().remove(imageView4);
                grid.add(imageView4, theTrackOfPawns.get(endPosition).getColumn(), theTrackOfPawns.get(endPosition).getRow());
                startPosition = 0;
                start = startPosition;
            } else {
                start = +endPosition;
                grid.getChildren().remove(imageView4);
                grid.add(imageView4, theTrackOfPawns.get(endPosition).getColumn(), theTrackOfPawns.get(endPosition).getRow());
            }
        } else if (basePawns.size() == 2 && homePawns.size() == 1) {
            int startPosition = start;
            int endPosition = resultOfDice + startPosition;
            if (endPosition > 43) {
                endPosition = startPosition;
            }
            if (endPosition == 43) {
                homePawns.add(imageView3);
                grid.getChildren().remove(imageView3);
                grid.add(imageView3, theTrackOfPawns.get(endPosition).getColumn(), theTrackOfPawns.get(endPosition).getRow());
                startPosition = 0;
                start = startPosition;
            } else {
                start = +endPosition;
                grid.getChildren().remove(imageView3);
                grid.add(imageView3, theTrackOfPawns.get(endPosition).getColumn(), theTrackOfPawns.get(endPosition).getRow());
            }
        } else if (basePawns.size() == 1 && homePawns.size() == 2) {
            int startPosition = start;
            int endPosition = resultOfDice + startPosition;
            if (endPosition > 42) {
                endPosition = startPosition;
            }
            if (endPosition == 42) {
                homePawns.add(imageView2);
                grid.getChildren().remove(imageView2);
                grid.add(imageView2, theTrackOfPawns.get(endPosition).getColumn(), theTrackOfPawns.get(endPosition).getRow());
                startPosition = 0;
                start = startPosition;
            } else {
                start = +endPosition;
                grid.getChildren().remove(imageView2);
                grid.add(imageView2, theTrackOfPawns.get(endPosition).getColumn(), theTrackOfPawns.get(endPosition).getRow());
            }
        } else if (basePawns.size() == 0 && homePawns.size() == 3) {
            int startPosition = start;
            int endPosition = resultOfDice + startPosition;
            if (endPosition > 41) {
                endPosition = startPosition;
            }
            if (endPosition == 41) {
                homePawns.add(imageView1);
                grid.getChildren().remove(imageView1);
                grid.add(imageView1, theTrackOfPawns.get(endPosition).getColumn(), theTrackOfPawns.get(endPosition).getRow());
                startPosition = 0;
                start = startPosition;
            } else {
                start = +endPosition;
                grid.getChildren().remove(imageView1);
                grid.add(imageView1, theTrackOfPawns.get(endPosition).getColumn(), theTrackOfPawns.get(endPosition).getRow());
            }
        }
        return start;
    }

    public int pawnBeatGreenPawn(int start1, int start2,
                                 Map<Integer, Point> actualPawns, Map<Integer, Point> roadOfGreenPawn,
                                 ImageView imageView1, ImageView imageView2, ImageView imageView3, ImageView imageView4,
                                 List greenHomePawns, Map<Integer, Point> homeGreen, GridPane grid) {

        if (actualPawns.get(start1).getColumn() == roadOfGreenPawn.get(start2).getColumn()) {
            if (actualPawns.get(start1).getRow() == roadOfGreenPawn.get(start2).getRow()) {
                if (greenHomePawns.size() == 3) {
                    grid.getChildren().remove(imageView4);
                    grid.add(imageView4, homeGreen.get(4).getColumn(), homeGreen.get(4).getRow());
                    greenHomePawns.add(4);
                } else if (greenHomePawns.size() == 2) {
                    grid.getChildren().remove(imageView3);
                    grid.add(imageView3, homeGreen.get(3).getColumn(), homeGreen.get(3).getRow());
                    greenHomePawns.add(3);
                } else if (greenHomePawns.size() == 1) {
                    grid.getChildren().remove(imageView2);
                    grid.add(imageView2, homeGreen.get(2).getColumn(), homeGreen.get(2).getRow());
                    greenHomePawns.add(2);
                } else if (greenHomePawns.size() == 0) {
                    grid.getChildren().remove(imageView1);
                    grid.add(imageView1, homeGreen.get(1).getColumn(), homeGreen.get(1).getRow());
                    greenHomePawns.add(1);
                }
                start2 = 0;
            }
        }
        return start2;
    }

    public int pawnBeatRedPawn(int start1, int start2,
                               Map<Integer, Point> actualPawns, Map<Integer, Point> roadOfRedPawn,
                               ImageView imageView1, ImageView imageView2, ImageView imageView3, ImageView imageView4,
                               List greenHomePawns, Map<Integer, Point> homeGreen, GridPane grid) {
        if (actualPawns.get(start1).getColumn() == roadOfRedPawn.get(start2).getColumn()) {
            if (actualPawns.get(start1).getRow() == roadOfRedPawn.get(start2).getRow()) {
                if (greenHomePawns.size() == 3) {
                    grid.getChildren().remove(imageView4);
                    grid.add(imageView4, homeGreen.get(4).getColumn(), homeGreen.get(4).getRow());
                    greenHomePawns.add(4);
                } else if (greenHomePawns.size() == 2) {
                    grid.getChildren().remove(imageView3);
                    grid.add(imageView3, homeGreen.get(3).getColumn(), homeGreen.get(3).getRow());
                    greenHomePawns.add(3);
                } else if (greenHomePawns.size() == 1) {
                    grid.getChildren().remove(imageView2);
                    grid.add(imageView2, homeGreen.get(2).getColumn(), homeGreen.get(2).getRow());
                    greenHomePawns.add(2);
                } else if (greenHomePawns.size() == 0) {
                    grid.getChildren().remove(imageView1);
                    grid.add(imageView1, homeGreen.get(1).getColumn(), homeGreen.get(1).getRow());
                    greenHomePawns.add(1);
                }
                start2 = 0;
            }
        }
        return start2;
    }

    public int pawnBeatBluePawn(int start1, int start2,
                                Map<Integer, Point> actualPawns, Map<Integer, Point> roadOfBluePawn,
                                ImageView imageView1, ImageView imageView2, ImageView imageView3, ImageView imageView4,
                                List greenHomePawns, Map<Integer, Point> homeGreen, GridPane grid) {

        if (actualPawns.get(start1).getColumn() == roadOfBluePawn.get(start2).getColumn()) {
            if (actualPawns.get(start1).getRow() == roadOfBluePawn.get(start2).getRow()) {
                if (greenHomePawns.size() == 3) {
                    grid.getChildren().remove(imageView4);
                    grid.add(imageView4, homeGreen.get(4).getColumn(), homeGreen.get(4).getRow());
                    greenHomePawns.add(4);
                } else if (greenHomePawns.size() == 2) {
                    grid.getChildren().remove(imageView3);
                    grid.add(imageView3, homeGreen.get(3).getColumn(), homeGreen.get(3).getRow());
                    greenHomePawns.add(3);
                } else if (greenHomePawns.size() == 1) {
                    grid.getChildren().remove(imageView2);
                    grid.add(imageView2, homeGreen.get(2).getColumn(), homeGreen.get(2).getRow());
                    greenHomePawns.add(2);
                } else if (greenHomePawns.size() == 0) {
                    grid.getChildren().remove(imageView1);
                    grid.add(imageView1, homeGreen.get(1).getColumn(), homeGreen.get(1).getRow());
                    greenHomePawns.add(1);
                }
                start2 = 0;
            }
        }
        return start2;
    }

    public int pawnBeatYellowPawn(int start1, int start2,
                                  Map<Integer, Point> actualPawns, Map<Integer, Point> roadOfYellowPawn,
                                  ImageView imageView1, ImageView imageView2, ImageView imageView3, ImageView imageView4,
                                  List greenHomePawns, Map<Integer, Point> homeGreen, GridPane grid) {
        if (actualPawns.get(start1).getColumn() == roadOfYellowPawn.get(start2).getColumn()) {
            if (actualPawns.get(start1).getRow() == roadOfYellowPawn.get(start2).getRow()) {
                if (greenHomePawns.size() == 3) {
                    grid.getChildren().remove(imageView4);
                    grid.add(imageView4, homeGreen.get(4).getColumn(), homeGreen.get(4).getRow());
                    greenHomePawns.add(4);
                } else if (greenHomePawns.size() == 2) {
                    grid.getChildren().remove(imageView3);
                    grid.add(imageView3, homeGreen.get(3).getColumn(), homeGreen.get(3).getRow());
                    greenHomePawns.add(3);
                } else if (greenHomePawns.size() == 1) {
                    grid.getChildren().remove(imageView2);
                    grid.add(imageView2, homeGreen.get(2).getColumn(), homeGreen.get(2).getRow());
                    greenHomePawns.add(2);
                } else if (greenHomePawns.size() == 0) {
                    grid.getChildren().remove(imageView1);
                    grid.add(imageView1, homeGreen.get(1).getColumn(), homeGreen.get(1).getRow());
                    greenHomePawns.add(1);
                }
                start2 = 0;
            }
        }
        return start2;
    }

    public void checkWinner(List basePawns1, List basePawns2, List basePawns3, List basePawns4,
                            List ranking) {
        if (ranking.contains(basePawns1) == false) {
            if (basePawns1.size() == 4) {
                ranking.add(basePawns1);
                if (ranking.size() == 1) {
                    System.out.println("Yellow win");
                } else if (ranking.size() == 2) {
                    System.out.println("Yellow 2nd");
                } else if (ranking.size() == 3) {
                    System.out.println("Yellow 3rd");
                }
            }
        }
        if (ranking.contains(basePawns2) == false) {
            if (basePawns2.size() == 4) {
                ranking.add(basePawns2);
                if (ranking.size() == 1) {
                    System.out.println("Green win");
                } else if (ranking.size() == 2) {
                    System.out.println("Green 2nd");
                } else if (ranking.size() == 3) {
                    System.out.println("Green 3rd");
                }
            }
        }
        if (ranking.contains(basePawns3) == false) {
            if (basePawns3.size() == 4) {
                ranking.add(basePawns3);
                if (ranking.size() == 1) {
                    System.out.println("Red win");
                } else if (ranking.size() == 2) {
                    System.out.println("Red 2nd");
                } else if (ranking.size() == 3) {
                    System.out.println("Red 3rd");
                }
            }
        }
        if (ranking.contains(basePawns4) == false) {
            if (basePawns4.size() == 4) {
                ranking.add(basePawns4);
                if (ranking.size() == 1) {
                    System.out.println("Blue win");
                } else if (ranking.size() == 2) {
                    System.out.println("Blue 2nd");
                } else if (ranking.size() == 3) {
                    System.out.println("Blue 3rd");
                }
            }
        }
        if (ranking.size() == 3) {
            if (ranking.contains(basePawns1) == false) {
                System.out.println("Yellow 4th");
            } else if (ranking.contains(basePawns2) == false) {
                System.out.println("Green 4th");
            } else if (ranking.contains(basePawns3) == false) {
                System.out.println("Red 4th");
            } else if (ranking.contains(basePawns4) == false) {
                System.out.println("Blue 4th");
            }
            System.out.println("Koniec gry");
        }
    }

    public void buttonsAbleAndDisable(List<Pawn> basePawnsYellow, List<Pawn> basePawnsGreen, List<Pawn> basePawnsRed, List<Pawn> basePawnsBlue,
                                      Button button1, Button button2, Button button3, Button button4,
                                      List<List> ranking) {
        if (basePawnsYellow.size() <= 4 && basePawnsGreen.size() != 4) {
            button1.setDisable(true);
            button2.setDisable(false);
        } else if (ranking.contains(basePawnsGreen) && basePawnsRed.size() != 4) {
            button1.setDisable(true);
            button2.setDisable(true);
            button3.setDisable(false);
        } else if (ranking.contains(basePawnsRed) && basePawnsBlue.size() != 4) {
            button1.setDisable(true);
            button2.setDisable(true);
            button3.setDisable(true);
            button4.setDisable(false);
        } else if (ranking.contains(basePawnsBlue) && basePawnsYellow.size() != 4) {
            button2.setDisable(true);
            button3.setDisable(true);
            button4.setDisable(true);
            button1.setDisable(false);
        }
        if (ranking.size() == 3) {
            button1.setDisable(true);
            button2.setDisable(true);
            button3.setDisable(true);
            button4.setDisable(true);
        }
        if (basePawnsYellow.size() == 4) {
            button1.setDisable(true);
            button1.fire();
        }
    }

    public void whoStart(Button button1, Button button2, Button button3, Button button4, int numbersOfPlayers) {
        int whoStartTheGame = whoStart.nextInt(4) + 1;
        if (numbersOfPlayers == 1) {
            if (whoStartTheGame == 1) {
                button1.setDisable(false);
                button2.setDisable(true);
                button3.setDisable(true);
                button4.setDisable(true);
                System.out.println("Yellow start");
            } else if (whoStartTheGame == 2) {
                button1.setDisable(true);
                button2.setDisable(false);
                button3.setDisable(true);
                button4.setDisable(true);
                button2.fire();
                System.out.println("Green start");
            } else if (whoStartTheGame == 3) {
                button1.setDisable(true);
                button2.setDisable(true);
                button3.setDisable(false);
                button4.setDisable(true);
                button3.fire();
                System.out.println("Red start");
            } else if (whoStartTheGame == 4) {
                button1.setDisable(true);
                button2.setDisable(true);
                button3.setDisable(true);
                button4.setDisable(false);
                button4.fire();
                System.out.println("Blue start");
            }
        } else if (numbersOfPlayers == 2) {
            if (whoStartTheGame == 1) {
                button1.setDisable(false);
                button2.setDisable(true);
                button3.setDisable(true);
                button4.setDisable(true);
                System.out.println("Yellow start");
            } else if (whoStartTheGame == 2) {
                button1.setDisable(true);
                button2.setDisable(false);
                button3.setDisable(true);
                button4.setDisable(true);
                System.out.println("Green start");
            } else if (whoStartTheGame == 3) {
                button1.setDisable(true);
                button2.setDisable(true);
                button3.setDisable(false);
                button4.setDisable(true);
                button3.fire();
                button4.fire();
                System.out.println("Red start");
            } else if (whoStartTheGame == 4) {
                button1.setDisable(true);
                button2.setDisable(true);
                button3.setDisable(true);
                button4.setDisable(false);
                button4.fire();
                System.out.println("Blue start");
            }
        } else if (numbersOfPlayers == 3) {
            if (whoStartTheGame == 1) {
                button1.setDisable(false);
                button2.setDisable(true);
                button3.setDisable(true);
                button4.setDisable(true);
                System.out.println("Yellow start");
            } else if (whoStartTheGame == 2) {
                button1.setDisable(true);
                button2.setDisable(false);
                button3.setDisable(true);
                button4.setDisable(true);
                System.out.println("Green start");
            } else if (whoStartTheGame == 3) {
                button1.setDisable(true);
                button2.setDisable(true);
                button3.setDisable(false);
                button4.setDisable(true);
                System.out.println("Red start");
            } else if (whoStartTheGame == 4) {
                button1.setDisable(true);
                button2.setDisable(true);
                button3.setDisable(true);
                button4.setDisable(false);
                button4.fire();
                System.out.println("Blue start");
            }
        } else if (numbersOfPlayers == 4) {
            if (whoStartTheGame == 1) {
                button1.setDisable(false);
                button2.setDisable(true);
                button3.setDisable(true);
                button4.setDisable(true);
                System.out.println("Yellow start");
            } else if (whoStartTheGame == 2) {
                button1.setDisable(true);
                button2.setDisable(false);
                button3.setDisable(true);
                button4.setDisable(true);
                System.out.println("Green start");
            } else if (whoStartTheGame == 3) {
                button1.setDisable(true);
                button2.setDisable(true);
                button3.setDisable(false);
                button4.setDisable(true);
                button3.fire();
                System.out.println("Red start");
            } else if (whoStartTheGame == 4) {
                button1.setDisable(true);
                button2.setDisable(true);
                button3.setDisable(true);
                button4.setDisable(false);
                System.out.println("Blue start");
            }
        }
    }

    public void computerMove(Button button1, Button button2, Button button3, int numbersOfPlayers) {

        if (numbersOfPlayers == 1) {
            if (button1.isDisable() == false) {
                button1.fire();
            } else if (button2.isDisable() == false) {
                button2.fire();
            } else if (button3.isDisable() == false) {
                button3.fire();
            }
        } else if (numbersOfPlayers == 2) {
            if (button1.isDisable() == false) {
                button1.fire();
            } else if (button2.isDisable() == false) {
                button2.fire();
            }
        } else if (numbersOfPlayers == 3) {
            if (button1.isDisable() == false) {
                button1.fire();
            }
        }
    }
}






