import pygame
import copy

pygame.init()  # initializes a window
screen = pygame.display.set_mode((600, 600))  # sets the size of the window to 600 * 600 and save to a variable
pygame.display.set_caption('alpha_beta')  # sets the title of the window

class TicTacToeGame:
    BACKGROUND_COLOR = (224, 172, 108)
    LINE_COLOR       = (161, 63, 2)
    FIG_COLOR        = (0, 0, 0)
    WHITE            = (255, 255, 255)

    def __init__(self):
        self.board =   [[0, 0, 0],
                        [0, 0, 0],
                        [0, 0, 0]]
        self.marked_squares = 0
        self.player = 1  # 1 for the human to start, 2 for the AI to start
        self.running = True

    def show_lines(self):  # draws the outlines of the board
        # draw vertical lines
        pygame.draw.line(screen, self.LINE_COLOR, (200, 0), (200, 600), 10)
        pygame.draw.line(screen, self.LINE_COLOR, (400, 0), (400, 600), 10)

        # draw horizontal lines
        pygame.draw.line(screen, self.LINE_COLOR, (0, 200), (600, 200), 10)
        pygame.draw.line(screen, self.LINE_COLOR, (0, 400), (600, 400), 10)

    def make_move(self, row, col):  # makes the moves on the board
        self.board[row][col] = self.player
        self.marked_squares += 1  # increment the marked squares attribute
        self.change_player()

    def change_player(self):  # alternates the player's value between 1 and 2 (1 for human, 2)
        self.player = self.player % 2 + 1

    def draw_fig(self, row, col):  # draws the Xs and the Os on the board
        # draw the X if player == 1
        if self.board[row][col] == 1:
            # first line
            start1 = (col * 200 + 50, row * 200 + 50)
            end1 = (col * 200 + 200 - 50, row * 200 + 200 - 50)
            pygame.draw.line(screen, self.FIG_COLOR, start1, end1, 15)

            # second line
            start2 = (col * 200 + 50, row * 200 + 200 - 50)
            end2 = (col * 200 + 200 - 50, row * 200 + 50)
            pygame.draw.line(screen, self.FIG_COLOR, start2, end2, 15)

        # draw the O if player == 2
        elif self.board[row][col] == 2:
            center = (col * 200 + 200 // 2, row * 200 + 200 // 2)
            pygame.draw.circle(screen, self.FIG_COLOR, center, 60, 10)

    def is_over(self):  # checks if there is a result already
        return self.check_state(show=True) != 0 or self.is_full()

    def reset_board(self):  # resets the board
        self.__init__() # calls the constructor

    def is_emptySquare(self, row, col):  # checks if the square we're trying to click is empty
        return self.board[row][col] == 0

    def get_empty_squares(self):  # returns all the empty squares on the board
        empty_squares = []
        for row in range(3):
            for col in range(3):
                if self.is_emptySquare(row, col):
                    empty_squares.append((row, col))
        return empty_squares

    def is_full(self):  # checks if the board is full
        return self.marked_squares == 9

    def is_empty(self):  # checks if the board is empty
        return self.marked_squares == 0

    def check_state(self, show=False):  # checks the board state
        
        for col in range(3):
            if self.board[0][col] == self.board[1][col] == self.board[2][col] != 0:
                if show:
                    pygame.draw.line(screen, self.WHITE, (col * 200 + 100, 20), (col * 200 + 100, 580), 10)
                return self.board[0][col]

        for row in range(3):
            if self.board[row][0] == self.board[row][1] == self.board[row][2] != 0:
                if show:
                    pygame.draw.line(screen, self.WHITE, (20, row * 200 + 100), (580, row * 200 + 100), 10)
                return self.board[row][0]

        if self.board[0][0] == self.board[1][1] == self.board[2][2] != 0:
            if show:
                pygame.draw.line(screen, self.WHITE, (20, 20), (580, 580), 10)
            return self.board[1][1]

        if self.board[2][0] == self.board[1][1] == self.board[0][2] != 0:
            if show:
                pygame.draw.line(screen, self.WHITE, (20, 580), (580, 20), 10)
            return self.board[1][1]

        return 0  # there is no win

    def eval(self):
        eval, move = self.alpha_beta(False)
        return move

    def alpha_beta(self, maximizing, alpha=-100, beta=100):
        case = self.check_state()

        if case == 1:
            return 1, None
        if case == 2:
            return -1, None
        elif self.is_full():
            return 0, None

        if maximizing:
            max_eval = -100
            best_move = None
            empty_squares = self.get_empty_squares()

            for (row, col) in empty_squares:
                temp_game = copy.deepcopy(self)
                temp_game.make_move(row, col)
                eval = temp_game.alpha_beta(False, alpha, beta)[0]

                if eval > max_eval:
                    max_eval = eval
                    best_move = (row, col)

                alpha = max(alpha, eval)
                if beta <= alpha:
                    break  # beta cut-off

            return max_eval, best_move

        else:  # minimizing
            min_eval = 100
            best_move = None
            empty_squares = self.get_empty_squares()

            for (row, col) in empty_squares:
                temp_game = copy.deepcopy(self)
                temp_game.make_move(row, col)
                eval = temp_game.alpha_beta(True, alpha, beta)[0]

                if eval < min_eval:
                    min_eval = eval
                    best_move = (row, col)

                beta = min(beta, eval)
                if beta <= alpha:
                    break  # alpha cut-off

            return min_eval, best_move


def main():  # main function
    game = TicTacToeGame()

    while True:
        for event in pygame.event.get():  # listen to the events
            if event.type == pygame.QUIT:
                pygame.quit()

            if event.type == pygame.KEYDOWN and event.key == pygame.K_r:
                game.reset_board()

            if event.type == pygame.MOUSEBUTTONDOWN:
                pos = event.pos  # a tuple contains the position of the mouse click
                row = pos[1] // 200
                col = pos[0] // 200

                if game.is_emptySquare(row, col) and game.running:
                    game.make_move(row, col)
                    if game.is_over():
                        game.running = False

        if game.player == 2 and game.running:
            row, col = game.eval()
            game.make_move(row, col)
            if game.is_over():
                game.running = False

        # clears the screen and redraws everything
        screen.fill(game.BACKGROUND_COLOR)
        game.show_lines()

        # draws figures after clearing the screen
        for row in range(3):
            for col in range(3):
                game.draw_fig(row, col)
                
        game.check_state(show=True)
        pygame.display.update()  # update the window after each iteration

main()  # call the main function to run the game