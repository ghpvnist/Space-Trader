import os

print("Loading game...")
# load ascii resources from files
ASCII_RESOURCES = {}
ASCII_RESOURCES_FOLDER = "ascii-resources"
for resource in os.listdir(ASCII_RESOURCES_FOLDER):
    with open(os.path.join(ASCII_RESOURCES_FOLDER, resource)) as file:
        ASCII_RESOURCES[resource[:resource.rfind(".")]] = file.read().rstrip('\n')

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


def main_menu():
    while True:
        print(ASCII_RESOURCES['title_art'])
        action = show_options(["New Game", "Load Game", "Settings"], cancel="Quit")
        if action == 0:
            #play_game(create_new_character())
            pass
        elif action == 1:
            #play_game(load_game())
            pass
        elif action == 2:
            print("Settings not currently implemented!")
        else:
            print("Thanks for playing!")
            return

if __name__ == "__main__":
    main_menu()
    
