//
//  Character.swift
//  iosApp
//
//  Created by klekchyan on 19.03.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct CharacterRow: View {
    var character: Character
    var body: some View {
        HStack() {
            VStack(alignment: .leading, spacing: 10.0) {
                Text("Name: \(character.name)")
                Text("Species: \(character.species)")
                if(character.wand != nil) {
                    Text("Wood: \(character.wand?.wood ?? "")")
                    Text("Species: \(character.wand?.core ?? "")")
                }
            }
            Spacer()
        }
    }
}

//struct Character_Previews: PreviewProvider {
//    static var previews: some View {
//        Character()
//    }
//}
