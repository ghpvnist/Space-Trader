import os
import pickle
import random
from enum import Enum

print("Loading game...")
# load ascii resources from files
ASCII_RESOURCES = {}
ASCII_RESOURCES_FOLDER = "ascii-resources"
for resource in os.listdir(ASCII_RESOURCES_FOLDER):
    with open(os.path.join(ASCII_RESOURCES_FOLDER, resource)) as file:
        ASCII_RESOURCES[resource[:resource.rfind(".")]] = file.read().rstrip('\n')

class TechLevel(Enum):
    PREAGRICULTURE = 0
    AGRICULTURE = 1
    MEDIEVAL = 2
    RENAISSANCE = 3
    EARLY_INDUSTRIAL = 4
    INDUSTRIAL = 5
    POST_INDUSTRIAL = 6
    HI_TECH = 7

class Resource(Enum):
    NOSPECIALRESOURCES = 0
    MINERALRICH = 1
    MINERALPOOR = 2
    DESERT = 3
    LOTSOFWATER = 4
    RICHSOIL = 5
    POORSOIL = 6
    RICHFAUNA = 7
    LIFELESS = 8
    WEIRDMUSHROOMS = 9
    LOTSOFHERBS = 10
    ARTISTIC = 11
    WARLIKE = 12


class GameData:

    def __init__(self, player, universe, player_location=None):
        self.player = player
        self.universe = universe
        if player_location is None:
            system = random.choice(list(universe.systems))
            planet = random.choice(list(system.planets))
            player_location = (system, planet)
        self.player_location = player_location
        

class Planet:

    def __init__(self, name, orbit, tech_level, resources, store=None):
        self.name = name
        self.orbit = orbit
        self.tech_level = tech_level
        self.resources = resources
        if store is None:
            store = self.generate_store()
        self.store = store

    def generate_store(self):
        return None

    ## worthless planets have low resources, techlevel, and no stores
    ## just used to fill solar systems
    def generate_worthless_planet():
        pass

class SolarSystem:
    
    def __init__(self, name, planets, tech_level):
        self.name = name
        self.planets = planets
        self.tech_level = tech_level

    def generate():
        name = generate_code()
        num_planets = random.randint(3, 6)
    

class Universe:
    pass

def weighted_random(weighted_choices):
    ## assumes already normalized
    r = random.random()
    idx = 0
    while r > weighted_choices[idx][0]:
        r -= weighted_choices[idx][0]
        idx += 1
    return weighted_choices[idx][1]

def generate_code(alph=2, num=3):
    return "".join(random.choice("ABCDEFGHIJKLMNOPQRSTUVWXYZ") for _ in range(alph)) + \
           "-" + "".join(random.choice("0123456789") for _ in range(num))


def draw_solar_system(system, height=30, width=80):
    for y in range(height):
        line = ""
        adj_y = (y - height//2)/(height//2)
        for x in range(width):
            adj_x = (x - width//2)/(width//2)
            if abs(adj_x**2 + adj_y**2 - 0.64) < 0.05:
                line += "."
            else:
                line += " "
        print(line)
            



def show_options(options, number=True, cancel="Cancel"):
    if not number:
        choices = [option[0] for option in options]
        options = [option[1] for option in options]
    else:
        choices = [str(index + 1) for index in range(len(options))]
    if cancel:
        options.append(cancel)
        choices.append(cancel[0])
    for pair in zip(choices, options):
        print("%s: %s" % pair)
    inp = None
    while inp not in choices:
        inp = input("> ")
        if inp not in choices:
            print("Choice not recognized!")
            print()
    return choices.index(inp)

SAVE_GAME_FOLDER = "saves"

def load_game():
    saves = []
    for i in range(5):
        file_path = os.path.join(SAVE_GAME_FOLDER, "%d.save" % i)
        if os.path.isfile(file_path):
            with open(file_path, "rb") as pickle_file:
                saves.append(pickle.load(pickle_file))
        else:
            saves.append(None)
    ## print saves?
    return None # TODO


def new_game():
    pass


def main_menu():
    while True:
        print(ASCII_RESOURCES['title_art'])
        action = show_options(["New Game", "Load Game", "Settings"], cancel="Quit")
        if action == 0:
            game = new_game()
            if game is None:
                continue
            play_game(game)
        elif action == 1:
            game = load_game()
            if game is None:
                continue
            play_game(game)
        elif action == 2:
            print("Settings not currently implemented!")
        else:
            print("Thanks for playing!")
            return

if __name__ == "__main__":
    main_menu()
    
