/*
 * Copyright 2014 The Ideal Authors. All rights reserved.
 *
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file or at
 * https://developers.google.com/open-source/licenses/bsd
 */

package ideal.experiment.mini;

import static ideal.experiment.mini.library.*;

import java.util.List;

import javax.annotation.Nullable;

/**
 * Autogenerated code, do not edit.
 */
public interface bootstrapped {
  interface text {
  }
  class text_string implements text {
    private final String value;
    public text_string(String value) {
      this.value = value;
    }
    public String value() {
      return value;
    }
  }
  class indented_text implements text {
    private final text inside;
    public indented_text(text inside) {
      this.inside = inside;
    }
    public text inside() {
      return inside;
    }
  }
  class text_list implements text {
    private final List<text> texts;
    public text_list(List<text> texts) {
      this.texts = texts;
    }
    public List<text> texts() {
      return texts;
    }
  }
  interface describable {
    text description();
  }
  interface source {
    @Nullable source the_source();
  }
  interface source_text extends source, describable {
    String name();
    String content();
    @Nullable source the_source();
  }
  class source_text_class implements source_text {
    private final String name;
    private final String content;
    public source_text_class(String name, String content) {
      this.name = name;
      this.content = content;
    }
    @Override public String name() {
      return name;
    }
    @Override public String content() {
      return content;
    }
    @Override public @Nullable source the_source() {
      return null;
    }
    @Override public text description() {
      return join_fragments("source_text_class", START_OBJECT, NEWLINE, indent(field_is("name", name)), END_OBJECT);
    }
  }
  interface text_position extends source, describable {
    source_text the_source();
    int character_index();
  }
  class text_position_class implements text_position {
    private final source_text the_source;
    private final int character_index;
    public text_position_class(source_text the_source, int character_index) {
      this.the_source = the_source;
      this.character_index = character_index;
    }
    @Override public source_text the_source() {
      return the_source;
    }
    @Override public int character_index() {
      return character_index;
    }
    @Override public text description() {
      return join_fragments("text_position_class", START_OBJECT, SPACE, describe(the_source), SPACE, END_OBJECT);
    }
  }
  enum token_type {
    WHITESPACE,
    COMMENT,
    OPEN,
    CLOSE,
    IDENTIFIER,
    LITERAL,
    MODIFIER;
  }
  interface token extends source {
    token_type type();
  }
  class simple_token implements token, describable {
    private final token_type type;
    private final source the_source;
    public simple_token(token_type type, source the_source) {
      this.type = type;
      this.the_source = the_source;
    }
    @Override public token_type type() {
      return type;
    }
    @Override public source the_source() {
      return the_source;
    }
    @Override public text description() {
      return join_fragments("simple_token", START_OBJECT, SPACE, describe(type), SPACE, END_OBJECT);
    }
  }
  interface construct extends source {
  }
  class identifier implements token, construct, describable {
    private final String name;
    private final source the_source;
    public identifier(String name, source the_source) {
      this.name = name;
      this.the_source = the_source;
    }
    public String name() {
      return name;
    }
    @Override public token_type type() {
      return token_type.IDENTIFIER;
    }
    @Override public source the_source() {
      return the_source;
    }
    @Override public text description() {
      return join_fragments("identifier", START_OBJECT, SPACE, describe(name), SPACE, END_OBJECT);
    }
  }
}
